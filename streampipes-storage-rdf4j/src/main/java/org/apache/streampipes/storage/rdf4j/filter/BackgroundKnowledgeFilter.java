/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.streampipes.storage.rdf4j.filter;

import org.apache.streampipes.model.client.ontology.OntologyNode;
import org.apache.streampipes.model.client.ontology.Property;
import org.apache.streampipes.storage.rdf4j.util.BackgroundKnowledgeUtils;
import org.apache.streampipes.vocabulary.StreamPipes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BackgroundKnowledgeFilter {

  public static List<String> omittedPropertyPrefixes = Arrays.asList(StreamPipes.NS,
          "http://schema.org/Thing", "http://purl.oclc.org/NET/ssnx/ssn#",
          "http://sepa.event-processing.org/sepa#",
          "http://www.w3.org/2000/01/rdf-schema#",
          "http://www.w3.org/1999/02/22-rdf-syntax-ns#");

  public static List<OntologyNode> propertiesFilter(List<OntologyNode> nodes, boolean filterDuplicates) {
    List<OntologyNode> filteredList = nodes
            .stream()
            .filter(n -> omittedPropertyPrefixes
                    .stream()
                    .noneMatch(op -> n.getId().startsWith(op)))
            .collect(Collectors.toList());
    if (filterDuplicates) {
      return BackgroundKnowledgeUtils.filterDuplicates(filteredList);
    } else {
      return filteredList;
    }
  }

  public static List<Property> rdfsFilter(List<Property> properties, boolean filterDuplicates) {
    List<Property> filteredList = properties
            .stream()
            .filter(n -> omittedPropertyPrefixes
                    .stream()
                    .noneMatch(op -> n.getElementHeader()
                            .getId()
                            .startsWith(op)))
            .collect(Collectors.toList());
    if (filterDuplicates) {
      return BackgroundKnowledgeUtils.filterDuplicates(filteredList);
    } else {
      return filteredList;
    }
  }


  public static List<OntologyNode> classFilter(List<OntologyNode> nodes, boolean filterDuplicates) {
    List<OntologyNode> filteredList = nodes
            .stream()
            .filter(n -> omittedPropertyPrefixes
                    .stream()
                    .noneMatch(op -> n
                            .getId()
                            .startsWith(op)))
            .collect(Collectors.toList());
    if (filterDuplicates) {
      return BackgroundKnowledgeUtils.filterDuplicates(filteredList);
    } else {
      return filteredList;
    }
  }
}
