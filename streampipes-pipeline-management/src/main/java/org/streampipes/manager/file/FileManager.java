/*
 * Copyright 2018 FZI Forschungszentrum Informatik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * you may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.streampipes.manager.file;

import org.streampipes.model.client.file.FileMetadata;
import org.streampipes.storage.api.IFileMetadataStorage;
import org.streampipes.storage.management.StorageDispatcher;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class FileManager {

  public static void storeFile(String user,
                               String filename,
                               InputStream fileInputStream) throws IOException {

    String filetype = filename.substring(filename.lastIndexOf(".") + 1);
    String internalFilename = makeInternalFilename(filetype);
    FileMetadata fileMetadata = makeFileMetadata(user, filename, internalFilename, filetype);
    new FileHandler().storeFile(internalFilename, fileInputStream);
    storeFileMetadata(fileMetadata);
  }

  public static void deleteFile(String id) {
    FileMetadata fileMetadata = getFileMetadataStorage().getMetadataById(id);
    new FileHandler().deleteFile(fileMetadata.getInternalFilename());
    getFileMetadataStorage().deleteFileMetadata(id);
  }

  public static File getFile(String filename) {
    return new FileHandler().getFile(filename);
  }

  private static void storeFileMetadata(FileMetadata fileMetadata) {
    getFileMetadataStorage().addFileMetadata(fileMetadata);
  }

  private static IFileMetadataStorage getFileMetadataStorage() {
    return StorageDispatcher
            .INSTANCE
            .getNoSqlStore()
            .getFileMetadataStorage();
  }

  private static FileMetadata makeFileMetadata(String user,
                                               String originalFilename,
                                               String internalFilename,
                                               String filetype) {

    FileMetadata fileMetadata = new FileMetadata();
    fileMetadata.setCreatedAt(System.currentTimeMillis());
    fileMetadata.setCreatedByUser(user);
    fileMetadata.setFiletype(filetype);
    fileMetadata.setInternalFilename(internalFilename);
    fileMetadata.setOriginalFilename(originalFilename);

    return fileMetadata;
  }

  private static String makeInternalFilename(String filetype) {
    return UUID.randomUUID().toString() + "." + filetype;
  }
}