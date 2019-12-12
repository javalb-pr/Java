<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <form action="/resolve/paramsForGroup" class="border border-primary rounded p-4 my-4">
        <span>Get params for selected product group</span>
        <p>
            Product group:
            <select name="productGroup" id="">
                <option value="phone">phone</option>
                <option value="vacation">vacation</option>
            </select>
        </p>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/productsWithNotHaveParam" class="border border-primary rounded p-4 my-4">
        <span>Get products with have NOT selected param</span>
        <p>
            Parameter:
            <select name="param" id="">
                <option value="meter">meter</option>
                <option value="second">second</option>
                <option value="day">day</option>
                <option value="year">year</option>
                <option value="kilogram">kilogram</option>
            </select>
        </p>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/productsWithProductsGroup" class="border border-primary rounded p-4 my-4">
        <span>Get products on selected product group</span>
        <p>
            Group:
            <select name="group" id="">
                <option value="phone">phone</option>
                <option value="vacation">vacation</option>
            </select>
        </p>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/allProducts" class="border border-primary rounded p-4 my-4">
        <span>Get all products</span>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/deleteProductsByParam" class="border border-primary rounded p-4 my-4">
        <span>Delete all products with selected params</span>
        <p>
            Parameter:
            <select name="param" id="">
                <option value="meter">meter</option>
                <option value="second">second</option>
                <option value="day">day</option>
                <option value="year">year</option>
                <option value="kilogram">kilogram</option>
            </select>
        </p>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/transferPramGroupToProductGroup" class="border border-primary rounded p-4 my-4">
        <span>Update param group in other product group</span>
        <p>
            Param group:
            <select name="paramGroup" id="">
                <option value="physical">physical</option>
                <option value="time">time</option>
                <option value="taste">taste</option>
            </select>
            to product group:
            <select name="productGroup" id="">
                <option value="phone">phone</option>
                <option value="vacation">vacation</option>
            </select>
        </p>
        <button type="submit">Submit</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>