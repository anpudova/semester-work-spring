<#import 'macros/leftRightLayout.ftl' as layout/>
<#import '/spring.ftl' as spring/>
<#import 'macros/card.ftl' as card/>

<@layout.entrance title="Search" pathJs='js/favorite_recipe.js'>
    <div class="main">
        <h2>Favorite recipes</h2>
    </div>
    <div class="container-card">
        <#if recipes?has_content>
            <#list recipes as recipe>
                <div class="card">
                    <div class="card-img">
                        <a href="${springMacroRequestContext.contextPath}/favorite/${recipe.id}">
                            <img src="${recipe.image}" class="card-img" alt="photo">
                        </a>
                    </div>
                    <div class="card-text">
                        <a href="${springMacroRequestContext.contextPath}/favorite/${recipe.id}">
                            <p class="card-name">${recipe.title}</p>
                        </a>
                    </div>
                </div>
            </#list>
        </#if>
    </div>
</@layout.entrance>