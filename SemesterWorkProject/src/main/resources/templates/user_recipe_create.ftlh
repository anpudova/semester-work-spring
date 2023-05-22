<#import 'macros/leftRightLayout.ftl' as layout/>
<#import 'macros/form.ftl' as form/>
<#import '/spring.ftl' as spring/>

<@layout.entrance title="CreateRecipe" pathJs='js/recipe_user.js'>
    <div class="main">
        <h2>Create recipe</h2>
    </div>
    <form action="${springMacroRequestContext.contextPath}/myRecipe/add" method="POST">
        <@form.input 'form.title' 'Title'/>
        <label>Category:</label>
        <br>
        <#list 0..1 as i>
            <label>
                <input type="checkbox" name="selectedCategory" value="${categories[i].id}">
                ${categories[i].name}
            </label><br>
        </#list>
        <label>Ingredients:</label>
        <button id="add-ing" type="button" class="btn btn-outline-success">Add</button>
        <div id="input-ingredient">
            <@form.input 'form.ingredients[' + 0 + '].ingredient' ''/>
        </div>
        <label>Steps:</label>
        <button id="add-step" type="button" class="btn btn-outline-success">Add</button>
        <div id="input-step">
            <@form.input 'form.steps[' + 0 + '].step' ''/>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <div class="form-button">
            <button type="submit" class="btn btn-block btn-outline-success btn-form">Save</button>
        </div>
    </form>
    <#if errorFields?has_content >
        <p>${errorFields}</p>
    </#if>
</@layout.entrance>