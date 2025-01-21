<li>Villy Siu</li>
<li>Daniel Noa</li>

<h1>Practice assignment</h1>

<h3>Create Table in Database:</h3>
<p><b>Customer table:</b>
id(int), email(varchar), fname(varchar), lname(varchar)</p>
<p><b>Item table:</b>
id(int), name(varchar), price(decimal(4,2)).</p>
<h3>Create models for each table.</h3>
<p>Create DAOs with the following methods:</p>
<p><b>CustomerDAO</b>
<li>getCustomerById(int id) - Returns the customer object for the given id.</li>
<li>addCustomer(Customer c) - Adds a customer with given information.</li>
<li>removeCustomerById(int id) - Removes a customer with the given id.</li>
</p>
<p><b>ItemDAO</b>
<li>getAllItems() - Returns a list of all item objects in the database.</li>
<li>addItem(Item i) - Adds an item with given information.</li>
<li>removeItemById(int id) - Removes an item with the given id.</li>
</p>
<p>Create additional classes and attributes.</p>

<h3>P.S.</h3>
Ensure you create a customerItemDB database before running the Spring boot application. Also, change the MySQL username and password as per the MySQL installation on your machine.
