<#import 'macros/leftRightLayout.ftl' as layout/>
<#import '/spring.ftl' as spring/>

<@layout.entrance title="Detail" pathJs='js/favorite_recipe.js'>
    <a href="${springMacroRequestContext.contextPath}/${lastPage}"><button class="btn btn-outline-success" type="button">Back</button></a>
    <div id="notification-container" style="margin-top: 10px">
        <#if user?has_content>
                <button id="favorite-btn" class="btn btn-outline-success" type="button"
                        onclick="toggleFavorite('${recipeId}', '${info.title}', '${info.image}', '${userId}')">
                    ${isFavorite}
                </button>
        </#if>
    </div>
    <div class="main">
        <h2>${info.title}</h2>
    </div>
    <img class="image-recipe" src="${info.image}" alt="Recipe Photo">
    <h3>Ingredients:</h3>
    <ul>
        <#list ingredient.ingredients as ing>
            <li>${ing.name}  ${ing.value} ${ing.unit}</li>
        </#list>
    </ul>
    <h3>Steps:</h3>
    <ol>
        <#list detail.steps as step>
            <li>${step.step}</li>
        </#list>
    </ol>
    <h3>Information:</h3>
    <#assign lastIndex = info.summary?replace('<b>', '')?replace('</b>', '')?last_index_of(". ")>
    <#assign substring = info.summary?replace('<b>', '')?replace('</b>', '')?substring(0, lastIndex + 1)>
    ${substring}
</@layout.entrance>