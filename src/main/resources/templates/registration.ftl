<#import "parts/common.ftl" as c>

<@c.page "Flight system">
    <div class="container mt-5">
        <form action="/addUser/${ticketId}" method="post">
            <div class="form-group">
                <label for="firstNameInput">First Name</label>
                <input type="text" name="firstName" class="form-control" id="firstNameInput" placeholder="First Name">
            </div>
            <div class="form-group">
                <label for="firstNameInput">Last Name</label>
                <input type="text" name="lastName" class="form-control" id="firstNameInput" placeholder="Last Name">
            </div>
            <div class="form-group">
                <label for="emailInput">Email address</label>
                <input type="email" name="email" class="form-control" id="emailInput" placeholder="name@example.com">
            </div>
            <div class="form-group">
                <label for="phoneInput">Phone</label>
                <input type="text" name="phone" class="form-control" id="phoneInput" placeholder="+375 xx xxx xx xx">
            </div>
            <div class="form-group">
                <label for="costInput">Cost</label>
                <input type="text" name="ticketCost"  class="form-control" id="costInput" value="${ticketCost} USD" disabled>
            </div>
            <button class="btn btn-success" type="submit">
                Register
            </button>
        </form>
    </div>
</@c.page>