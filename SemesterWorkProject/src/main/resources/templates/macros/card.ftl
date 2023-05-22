<#import '/spring.ftl' as spring/>

<#macro item path name image>
    <div class="card">
    <div class="card-img">
        <a href="${springMacroRequestContext.contextPath}/recipe/${path}">
            <img src="${image}" class="card-img" alt="photo">
        </a>
    </div>
    <div class="card-text">
        <a href="${springMacroRequestContext.contextPath}/recipe/${path}">
            <p class="card-name">${name}</p>
        </a>
    </div>
</div>
</#macro>