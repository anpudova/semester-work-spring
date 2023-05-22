<#ftl encoding="UTF-8"/>

<#import '/spring.ftl' as spring/>

<#macro main title pathJs>
<html lang="en">
<head>
    <title>${title}</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${springMacroRequestContext.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light my-navbar">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">CookBook</a>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link" href="${springMacroRequestContext.contextPath}/recipe">Search</a>
                </li>
                <#if user?has_content>
                    <li class="nav-item">
                        <a class="nav-link" href="${springMacroRequestContext.contextPath}/favorite">Favorites</a>
                    </li>
                </#if>
                <#if user?has_content>
                    <li class="nav-item">
                        <a class="nav-link" href="${springMacroRequestContext.contextPath}/myRecipe">My recipes</a>
                    </li>
                </#if>

            </ul>
            <#if user?has_content>
                <a href="${springMacroRequestContext.contextPath}/profile"><button class="btn btn-outline-success" type="submit">Profile</button></a>
            </#if>
            <#if !user?has_content>
                <a href="${springMacroRequestContext.contextPath}/signIn"><button class="btn btn-outline-success" type="submit">SignIn</button></a>
            </#if>

        </div>
    </div>
</nav>
<#nested>
<footer class="text-center text-lg-start bg-light text-muted">
    <div class="text-center p-4">
        © 2023 Copyright:
        <span class="text-reset fw-bold">CookBook</span>
    </div>
</footer>
<script>ctx = "${springMacroRequestContext.contextPath}"</script>
<#if pathJs?has_content>
    <script type="text/javascript" src="${springMacroRequestContext.contextPath}/${pathJs}"></script>
</#if>
</body>
</html>
</#macro>