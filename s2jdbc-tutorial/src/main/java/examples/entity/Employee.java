/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
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
package examples.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * 従業員です。
 * 
 * @author higa
 * 
 */
@Entity
public class Employee {

    /**
     * 識別子です。
     */
    @Id
    @GeneratedValue
    public Integer id;

    /**
     * 名前です。
     */
    public String name;

    /**
     * 仕事のタイプです。
     */
    public JobType jobType;

    /**
     * 給与です。
     */
    public Integer salary;

    /**
     * 部署の識別子です。
     */
    public Integer departmentId;

    /**
     * 部署です。
     */
    @ManyToOne
    public Department department;

    /**
     * 住所の識別子です。
     */
    public Integer addressId;

    /**
     * 住所です。
     */
    @OneToOne
    public Address address;
    /**
     * バージョンです。
     */
    @Version
    public Integer version;
}
