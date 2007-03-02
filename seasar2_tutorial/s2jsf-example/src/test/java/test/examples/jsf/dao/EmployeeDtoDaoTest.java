/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package test.examples.jsf.dao;

import org.seasar.dao.unit.S2DaoTestCase;

import examples.jsf.dao.EmployeeDtoDao;
import examples.jsf.dto.EmployeeSearchDto;

/**
 * @author higa
 *
 */
public class EmployeeDtoDaoTest extends S2DaoTestCase {

    private EmployeeDtoDao employeeDtoDao_;

    public void setUpContainer() throws Throwable {
        setServletContext(new MyMockServletContextImpl());
        super.setUpContainer();
    }

    public void setUp() {
        include("app.dicon");
    }

    public void testGetSearchCount() throws Exception {
        EmployeeSearchDto searchDto = new EmployeeSearchDto();
        searchDto.setEmpno(new Integer(7788));
        assertEquals("1", 1, employeeDtoDao_.getSearchCount(searchDto));
    }

    public void testSearchEmployeeDtoList() throws Exception {
        EmployeeSearchDto searchDto = new EmployeeSearchDto();
        searchDto.setEmpno(new Integer(7788));
        assertNotNull("1", employeeDtoDao_.searchEmployeeDtoList(searchDto));
    }

    public void testGetEmployeeDto() throws Exception {
        assertNotNull("1", employeeDtoDao_.getEmployeeDto(new Integer(7788)));
    }
}