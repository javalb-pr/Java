<#import "parts/common.ftl" as c>

<@c.page "Flight system">
    <div class="container mt-5">
        <div class="row">
            <div class="col-11">
                <ul class="list-group list-group-flush">
                    <#list flights as item>
                        <li class="list-group-item">
                            <h4>
                                ${item.name}
                                <span class="badge badge-secondary">${item.capacity} places</span>
                            </h4>
                        </li>
                        <ul class="list-group list-group-flush ml-5">
                            <#list item.getTickets() as ticket>
                                <li class="list-group-item">
                                    <h6 class="d-flex justify-content-between">
                                        <div>
                                            ${ticket.title}
                                            <span class="badge badge-secondary">${ticket.cost} USD</span>
                                        </div>
                                        <div>
                                            <a href="/registrationTicket/${ticket.id}" class="btn btn-success btn-sm">Register user</a>
                                            <a href="showAllByTicket/${ticket.id}" class="btn btn-info btn-sm">Show users</a>
                                        </div>
                                    </h6>
                                </li>
                            </#list>
                        </ul>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</@c.page>