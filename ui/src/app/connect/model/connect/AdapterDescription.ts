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

import {RdfId} from '../../../platform-services/tsonld/RdfId';
import {RdfProperty} from '../../../platform-services/tsonld/RdfsProperty';
import {RdfsClass} from '../../../platform-services/tsonld/RdfsClass';
import {TransformationRuleDescription} from './rules/TransformationRuleDescription';
import {StaticProperty} from '../StaticProperty';

@RdfsClass('sp:AdapterDescription')
export class AdapterDescription {

  @RdfId
  public id: string;

  @RdfProperty('http://www.w3.org/2000/01/rdf-schema#label')
  public label: string;

  @RdfProperty('http://www.w3.org/2000/01/rdf-schema#description')
  public description: string;

  @RdfProperty('sp:hasAppId')
  public appId: string;

  @RdfProperty('sp:couchDBId')
  public couchDbId: string;

  @RdfProperty('sp:userName')
  public userName: string;

  @RdfProperty('sp:hasUri')
  public uri: string;

  @RdfProperty('sp:iconUrl')
  public iconUrl: string;

  @RdfProperty('sp:icon')
  public icon: string;

  @RdfProperty('sp:hasAdapterType')
  public category: string[] = [];

  @RdfProperty('sp:adapterType')
  public adapterType: string;

  @RdfProperty('sp:rules')
  public rules: TransformationRuleDescription[];

  @RdfProperty('sp:config')
  public config: StaticProperty[] = [];

  public templateTitle: String;

  public isTemplate: boolean;

  constructor(id: string) {
    this.id = id;
  }

}
