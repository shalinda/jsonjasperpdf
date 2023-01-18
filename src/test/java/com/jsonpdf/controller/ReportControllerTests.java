/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jsonpdf.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReportControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void paramReportShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(post("/report").
                param("name", "employee").
                param("product", "emp1").
                contentType("application/json").
                content("[{\"name\":\"shalinda\", \"age\": 10, \"salary\": \"1000.0\",\"child\":{\"name\":\"duwi\"}},{\"name\":\"dilshan\", \"age\":21, \"salary\": 2300, \"child\":{\"name\":\"jani\"}}]"))
                .andDo(print()).andExpect(status().isOk());

    }

}
