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

package edu.umn.biomedicus.rtf.reader;

import java.nio.ByteBuffer;

public class PlainTextSink implements RtfSink {
  private final StringBuilder builder = new StringBuilder();

  @Override
  public void handleBinary(ByteBuffer byteBuffer, int startIndex, int endIndex) {

  }

  @Override
  public void writeCharacter(String destinationName, char c, int startIndex, int endIndex) {
    if (destinationName.equals("Rtf")) {
      builder.append(c);
    }
  }

  @Override
  public void propertyChanged(String destinationName, String propertyGroup, String propertyName, int oldValue, int newValue) {

  }

  public String getText() {
    return builder.toString();
  }
}
