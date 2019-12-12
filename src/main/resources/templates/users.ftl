<#import "parts/common.ftl" as c>

<@c.page "Flight system">
    <div class="row">
        <div class="col">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                </tr>
                </thead>
                <tbody>
                <#list users as user>
                    <tr>
                        <th scope="row">${user.firstName}</th>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
            <a href="/" class="btn btn-danger">Back</a>
        </div>
    </div>
</@c.page>