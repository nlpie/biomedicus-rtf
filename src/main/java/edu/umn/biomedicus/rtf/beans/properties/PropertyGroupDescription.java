/*
 * Copyright 2019 Regents of the University of Minnesota.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.umn.biomedicus.rtf.beans.properties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
@XmlRootElement
@XmlType
public class PropertyGroupDescription {

  private String name;

  private List<PropertyDescription> propertyDescriptions;

  @XmlElement
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlElementWrapper(name = "properties", required = true)
  @XmlElement(name = "property")
  public List<PropertyDescription> getPropertyDescriptions() {
    return propertyDescriptions;
  }

  public void setPropertyDescriptions(List<PropertyDescription> propertyDescriptions) {
    this.propertyDescriptions = propertyDescriptions;
  }

  public Map<String, Integer> createPropertyGroup() {
    return propertyDescriptions.stream()
        .collect(Collectors
            .toMap(PropertyDescription::getName, PropertyDescription::getDefaultValueOrZero));
  }
}
