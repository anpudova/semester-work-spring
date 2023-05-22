<#import 'macros/leftRightLayout.ftl' as layout/>
<#import '/spring.ftl' as spring/>
<#import 'macros/card.ftl' as card/>

<@layout.entrance title="MyRecipe" pathJs=''>
    <div class="main">
        <h2>My recipes</h2>
    </div>
    <div class="input-group mb-3">
        <a href="${springMacroRequestContext.contextPath}/myRecipe/add">
        <button class="btn btn-outline-success" type="button">Add recipe</button>
        </a>
    </div>

    <div class="container-card">
        <#if recipes?has_content>
            <#list recipes as recipe>
                <div class="card">
                    <div class="card-img">
                        <a href="${springMacroRequestContext.contextPath}/myRecipe/${recipe.id}">
                            <img src="${springMacroRequestContext.contextPath}/img/recipe.png" class="card-img" alt="photo">
                        </a>
                    </div>
                    <div class="card-text">
                        <a href="${springMacroRequestContext.contextPath}/myRecipe/${recipe.id}">
                            <p class="card-name">${recipe.title}</p>
                        </a>
                    </div>
                </div>
            </#list>
        </#if>
    </div>
</@layout.entrance>