package ${packageName};

<#list importPackageNameSet as importPackageName>
import ${importPackageName};
</#list>

public class ${shortClassName} extends
        AbstractEntityCondition<${shortClassName}> {

    public ${shortClassName}() {
    }

    public ${shortClassName}(String prefix, ComplexWhere where) {
        super(prefix, where);
    }
<#list conditionAttributeModelList as attr>

    public ${attr.conditionClass.simpleName}<${shortClassName}<#if attr.parameterized>, ${attr.attributeClass.simpleName}</#if>> ${attr.name} =
        new ${attr.conditionClass.simpleName}<${shortClassName}<#if attr.parameterized>, ${attr.attributeClass.simpleName}</#if>>("${attr.name}", this);
</#list>
<#list conditionMethodModelList as method>

    public ${method.returnShortClassName} ${method.name}() {
        return new ${method.returnShortClassName}(prefix + "${method.name}.", where);
    } 
</#list>
}