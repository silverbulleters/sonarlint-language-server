/*
 * SonarLint Language Server
 * Copyright (C) 2009-2020 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarsource.sonarlint.ls;

import com.google.gson.annotations.Expose;
import java.util.Map;

public class TelemetryEvent {

  @Expose
  private ServerTelemetryType type;

  @Expose
  private String eventName;

  @Expose
  private Map<String, Object> properties;

  @Expose
  private Map<String, Object> measures;

  @Expose
  private String stack;

  @Expose
  private String metricName;

  @Expose
  private Number metricValue;

  enum ServerTelemetryType {
    EVENT(0),
    ERROR(1),
    METRIC(2);

    // Do not rename, see EnumTypeAdapter
    private final int value;

    private ServerTelemetryType(int serializedValue) {
      this.value = serializedValue;
    }

  }

  public TelemetryEvent(String metricName, Number metricValue, Map<String, Object> properties) {
    this.type = ServerTelemetryType.METRIC;
    this.metricName = metricName;
    this.metricValue = metricValue;
    this.properties = properties;
  }

}
