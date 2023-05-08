# Example Of Spring (SpringBoot) + JasperReports

This is an example of SpringBoot and JasperReport to generate report/documents. I created this project to serve as a template project in case I need to use Jasper (which very common in Java DEV world).

## Run Local

To run this project on your local :

```bash
git pull {githubtothisproject}

cd {projectdir}

mvn spring-boot:run
```

project should run at localhost at port 8081 by default.

## Project Use Case

A very simple use case was created for this project. An endpoint to generate invoice of transaction based on request.

## Request Example

To understand the use case more, below is the request example :

```json
{
    "invoiceNumber" : "001001",
    "invoiceDate" : "08/05/2023",
    "customer" : {
        "customerId" : "cust-001",
        "customerName" : "Arief Salim",
        "customerEmail" : "arief-salim@gmail.com",
        "customerPhoneNumber" : "+6281234567890",
        "customerAddress" : "Ganteng Street No. 17 , Central Jakarta, Jakarta, Republic Indonesia"
    },
    "product" : {
        "productId" : "prd-001",
        "productName" : "Xiaomi NFC 4",
        "unitPrice" : "3.500.000",
        "buyQuantity" : "2",
        "totalPrice" : "7.000.000"
    }
}
```

After you run the application , you can generate the invoice document by send the POST request to :

```bash
localhost:8081/report/generate-invoice
```

## Generated Invoice

You can find the example of generated invoice in below snapshot:

![Image1](/github/example-invoice.png)

## JRXML Template

I created my own template for this project , you could get by pulling this project . It's located on **resources/example-invoice.jrxml**
