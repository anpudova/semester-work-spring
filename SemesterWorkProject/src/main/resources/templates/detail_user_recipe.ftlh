<#import 'macros/leftRightLayout.ftl' as layout/>
<#import '/spring.ftl' as spring/>

<@layout.entrance title="DetailMyRecipe" pathJs=''>
    <a href="${springMacroRequestContext.contextPath}/myRecipe"><button class="btn btn-outline-success" type="button">Back</button></a>

    <div class="main">
        <h2>${recipe.title}</h2>
        <p>Date of creation: ${recipe.date}</p>
    </div>
    <h3>Categories:</h3>
    <ul>
        <#list recipe.category as category>
            <li>${category.name}</li>
        </#list>
    </ul>
    <h3>Ingredients:</h3>
    <ul>
        <#list recipe.ingredients as ing>
            <#if ing.name?has_content>
                <li>${ing.name}</li>
            </#if>
        </#list>
    </ul>
    <h3>Steps:</h3>
    <ol>
        <#list recipe.steps as step>
            <#if step.name?has_content>
                <li>${step.name}</li>
            </#if>
        </#list>
    </ol>
    <a href="${springMacroRequestContext.contextPath}/myRecipe/delete/${recipe.id}"><button class="btn btn-outline-success" type="button">Delete recipe</button></a>
</@layout.entrance>