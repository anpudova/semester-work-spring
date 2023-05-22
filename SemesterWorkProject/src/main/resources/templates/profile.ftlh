<#import 'macros/leftRightLayout.ftl' as layout/>
<#import '/spring.ftl' as spring/>

<@layout.entrance title="Profile" pathJs=''>
<div class="main">
    <h2>Profile</h2>
    <#if isAdmin>
        <a href="${springMacroRequestContext.contextPath}/admin">
        <button type="button" class="btn btn-block btn-outline-secondary my-btn">Open Dashboard</button>
    </a>
    </#if>
</div>
<div class="parent-profile">
        <div class="container py-4 h-100" style="margin: 0;">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-10">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body text-center" style="padding: 0 0 10px;">
                            <div>
                                <img src="${springMacroRequestContext.contextPath}/img/profile.png"
                                     class="rounded-circle img-fluid" style="width: 170px;" />
                            </div>
                            <h4 class="mb-2">${user.username}</h4>
                            <a href="${springMacroRequestContext.contextPath}/profile/edit">
                                <button type="button" class="btn btn-block btn-outline-success my-btn">Edit profile</button>
                            </a>
                            <p><a href="${springMacroRequestContext.contextPath}/logout">
                                <button type="button" class="btn btn-block btn-outline-success my-btn">Exit</button>
                                </a></p>
                            <p> </p>
                            <a href="${springMacroRequestContext.contextPath}/delete">
                                <button type="button" class="btn btn-block btn-outline-secondary my-btn">Delete account</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
</@layout.entrance>