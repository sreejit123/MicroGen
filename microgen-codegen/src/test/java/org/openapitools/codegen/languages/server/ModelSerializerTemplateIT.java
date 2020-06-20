/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.openapitools.codegen.languages.server;

import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openapitools.codegen.languages.TemplateType;

import java.nio.file.Path;
import java.util.stream.Stream;

class ModelSerializerTemplateIT implements ServerTemplateTest {

    @TempDir
    Path tmpFolder;

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("petstore", "PetSerializer.java"),
                Arguments.of("petstore", "UserSerializer.java"),
                Arguments.of("petstore", "CategorySerializer.java"),
                Arguments.of("petstore", "OrderSerializer.java"),
                Arguments.of("petstore", "TagSerializer.java"),
                Arguments.of("example", "AllPrimitivesSerializer.java"),
                Arguments.of("example", "EnumStringSerializer.java"),
                Arguments.of("example", "EnumIntegerSerializer.java"),
                Arguments.of("example", "EnumNumberSerializer.java"),
                Arguments.of("example", "SampleBaseSerializer.java"),
                Arguments.of("example", "SampleSubClassSerializer.java"),
                Arguments.of("example", "PersonCardSerializer.java"),
                Arguments.of("example", "BaseCardSerializer.java"),
                Arguments.of("example", "ModelWithPropertiesAndAdditionalPropertiesSerializer.java"),
                Arguments.of("example", "ModelWithMapPropertiesSerializer.java"),
                Arguments.of("example", "ModelWithReadOnlyPropertyTestSerializer.java")
        );
    }

    @ParameterizedTest(name = "Generated {1} should be equals to fixtures/model/{1}")
    @MethodSource("arguments")
    void test(final String openAPIFile,
              final String expectedFile) {
        this.executeTest(openAPIFile, expectedFile, this.tmpFolder);

    }

    @Override
    public TemplateType templateToTest() {
        return TemplateType.SERVER_MODEL;
    }
}
