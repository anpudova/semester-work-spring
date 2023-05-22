<#import 'macros/leftRightLayout.ftl' as layout/>
<#import '/spring.ftl' as spring/>
<#import 'macros/card.ftl' as card/>

<@layout.entrance title="Search" pathJs='js/favorite_recipe.js'>
    <div class="main">
        <h2>Search recipe</h2>
    </div>
    <form action="${springMacroRequestContext.contextPath}/recipe" method="post">
        <div class="input-group mb-3">
            <label>
                <input type="text" name="search" class="form-control">
            </label>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button class="btn btn-outline-success" type="submit" id="button-addon2">Search</button>
        </div>
    </form>
    <div class="container-card">
        <#if recipes?has_content>

            <#list recipes.recipes as recipe>
                <div class="card">
                    <div class="card-img">
                        <a href="${springMacroRequestContext.contextPath}/recipe/${recipe.id}">
                            <img src="${recipe.image}" class="card-img" alt="photo">
                        </a>
                    </div>
                    <div class="card-text">
                        <a href="${springMacroRequestContext.contextPath}/recipe/${recipe.id}">
                            <p class="card-name">${recipe.title}</p>
                        </a>
                    </div>
                </div>
            </#list>
        </#if>
        <#if message?has_content>
            <div class="card">
                <p style="margin-bottom: 0;">Nothing found for your request :(</p>
            </div>
        </#if>
        <#if top?has_content>
            <h6> Recommended for viewing:</h6>
            <#list top as recipe>
                <div class="card">
                    <div class="card-img">
                        <a href="${springMacroRequestContext.contextPath}/recipe/${recipe.id}">
                            <img src="${recipe.image}" class="card-img" alt="photo">
                        </a>
                    </div>
                    <div class="card-text">
                        <a href="${springMacroRequestContext.contextPath}/recipe/${recipe.id}">
                            <p class="card-name">${recipe.title}</p>
                        </a>
                    </div>
                </div>
            </#list>
        </#if>
    </div>
</@layout.entrance>