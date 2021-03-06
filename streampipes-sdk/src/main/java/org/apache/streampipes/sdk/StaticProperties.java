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

package org.apache.streampipes.sdk;

import org.apache.streampipes.model.staticproperty.FreeTextStaticProperty;
import org.apache.streampipes.model.staticproperty.OneOfStaticProperty;
import org.apache.streampipes.model.staticproperty.Option;
import org.apache.streampipes.model.staticproperty.PropertyValueSpecification;
import org.apache.streampipes.model.staticproperty.RuntimeResolvableAnyStaticProperty;
import org.apache.streampipes.model.staticproperty.RuntimeResolvableOneOfStaticProperty;
import org.apache.streampipes.model.staticproperty.SecretStaticProperty;
import org.apache.streampipes.model.staticproperty.StaticProperty;
import org.apache.streampipes.model.staticproperty.StaticPropertyGroup;
import org.apache.streampipes.model.staticproperty.SupportedProperty;
import org.apache.streampipes.sdk.helpers.Label;
import org.apache.streampipes.sdk.utils.Datatypes;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class StaticProperties {

  public static FreeTextStaticProperty stringFreeTextProperty(Label label) {
    return freeTextProperty(label, Datatypes.String);
  }

  public static FreeTextStaticProperty integerFreeTextProperty(Label label) {
    return freeTextProperty(label, Datatypes.Integer);
  }

  public static FreeTextStaticProperty doubleFreeTextProperty(Label label) {
    return freeTextProperty(label, Datatypes.Double);
  }

  public static FreeTextStaticProperty freeTextProperty(Label label, Datatypes datatype) {
    FreeTextStaticProperty fsp = new FreeTextStaticProperty(label.getInternalId(), label.getLabel(),
            label.getDescription());
    fsp.setRequiredDatatype(URI.create(datatype.toString()));
    return fsp;
  }

  public static RuntimeResolvableOneOfStaticProperty singleValueSelectionFromContainer(Label label) {
    return new RuntimeResolvableOneOfStaticProperty(label.getInternalId(), label
            .getLabel(), label.getDescription());
  }

  public static RuntimeResolvableOneOfStaticProperty singleValueSelectionFromContainer(Label label, List<String> dependsOn) {
    RuntimeResolvableOneOfStaticProperty rsp = new RuntimeResolvableOneOfStaticProperty(label.getInternalId(), label
            .getLabel(), label.getDescription());
    rsp.setDependsOn(dependsOn);
    return rsp;
  }

  public static RuntimeResolvableAnyStaticProperty multiValueSelectionFromContainer(Label label) {
    return new RuntimeResolvableAnyStaticProperty(label.getInternalId(), label
            .getLabel(), label.getDescription());
  }

  public static RuntimeResolvableAnyStaticProperty multiValueSelectionFromContainer(Label label,
                                                                                  List<String> dependsOn) {
    RuntimeResolvableAnyStaticProperty rsp =
            new RuntimeResolvableAnyStaticProperty(label.getInternalId(), label
            .getLabel(), label.getDescription());
    rsp.setDependsOn(dependsOn);
    return rsp;
  }

  public static StaticProperty integerFreeTextProperty(Label label,
                                                       PropertyValueSpecification propertyValueSpecification) {
    FreeTextStaticProperty fsp = integerFreeTextProperty(label);
    fsp.setValueSpecification(propertyValueSpecification);
    return fsp;
  }

  public static SupportedProperty supportedDomainProperty(String rdfPropertyUri, boolean required) {
    return new SupportedProperty(rdfPropertyUri, required);
  }

  public static StaticPropertyGroup group(Label label, StaticProperty... sp) {
    List<StaticProperty> staticProperties = Arrays.asList(sp);
    for (int i = 0; i < staticProperties.size(); i++) {
      staticProperties.get(i).setIndex(i);
    }
    return new StaticPropertyGroup(label.getInternalId(), label.getLabel(),
            label.getDescription(), staticProperties);
  }

  public static OneOfStaticProperty singleValueSelection(Label label, List<Option> options) {
    OneOfStaticProperty osp = new OneOfStaticProperty(label.getInternalId(), label.getLabel(),
            label.getDescription());
    osp.setOptions(options);

    return osp;
  }

  public static SecretStaticProperty secretValue(Label label) {
    return new SecretStaticProperty(label.getInternalId(),
            label.getLabel(), label.getDescription());
  }
}
