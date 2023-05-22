<#import 'macros/leftRightLayout.ftl' as layout/>
<#import 'macros/form.ftl' as form/>
<#import '/spring.ftl' as spring/>

<@layout.entrance title="Admin" pathJs=''>
    <div class="main">
        <h2>Dashboard</h2>

    </div>
    <div class="parent-profile">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Username</th>
                <th scope="col">State</th>
            </tr>
            </thead>
            <tbody>
            <#if users?has_content>
                <#list users as user>
                    <tr>
                        <th scope="row">${user.id}</th>
                        <td>${user.username}</td>
                        <td>${user.state}</td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@layout.entrance>