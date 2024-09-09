# Lab 12: Sierpinski Triangles

In this lab, you will generate images of Sierpinski Triangles using Java graphics and recursion. Then, you'll add these images to a web page, host this web page to a server on Google Cloud Platform virtual machine, and then setup your server so that your page can be accessed using `<firstnamelastname>.sooners.us`.

## 1-Setting up the VM
You'll need to create a new VM on GCP and start-up an nginx webserver. Refer back to Lab 11 instructions if needed.

### Reserve a Static IP address and Attach it to the VM
In addition to that you'll need to reserve a static IP address for your machine, so that it can be used with the sub-domain redirection. 
For instructions on how to accomplish this, refer to [GCP documentation](https://cloud.google.com/compute/docs/ip-addresses/reserve-static-external-ip-address).

## 2-Submit Your IP and name - ⚠️ DUE BY THE END OF THURSDAY 04/27 ⚠️
In order to create the sub-domain for you (`<firstnamelastname>.sooners.us`), we need you to provide a few details through this [Google Form](https://docs.google.com/forms/d/1gRiMiHvHuNAxuZ6eSiIkl1ij6Bzo5mCOkLi7Rl6o4nc/viewform). Make sure you use the same name for "Supporting HTTPS" step. 
<b><u>
```diff
Be sure to submit this form by the end of Thursday 04/27.
```
</u></b>
## 3-Drawing Sierpinski Triangles

More information about these triangles can be found at [Wikipedia](https://en.wikipedia.org/wiki/Sierpi%C5%84ski_triangle). After generating Sierpinski Triangles of a specific depth, you need to use Java to save it as an image. Generate at least 9 images for different depths from 0 to 8. You can find a lot of online resources on generating these triangles using recursion in Java.

## 4-Building the Webpage

In this repository, you'll find a directory called `html`. Inside this directory, you'll find another directory called `images`. First, copy the images you generated from the previous step to this directory. Then, modify the file `index.html` so that it displays these images.

## 5-Configuring the Web Server with a Domain Name

As you have noticed, while surfing the internet we do not type the IP address of the website we are trying to browse (like we did for Lab 11). Instead, we use a name to tell the browser to fetch pages from that website. Names are used instead of IP addresses because they are much easier to remember. Domain Name Servers (DNS) are responsible for mapping names to IP addresses. Everytime you type a website name in your browser's address bar, if your browser does not already know the IP address of this website (not cached), it asks the DNS server for the IP address corresponding to that name, and then connects to this IP address. 

In this lab, we will be referring to our web server using names instead of just IP addresses. In order to do this, we are providing you with a sub-domain (`subdomain.sooners.us`) after you submit the form above (step 2 of this lab). In order for this name to work with your webserver, you need to do the following steps:

After having your web page files in `html` directory, you need to make them visible to `nginx` so that you can access the webpage from the browser. The easiest way of doing this is to copy these files to the default directory where nginx looks for web pages. You can do this as follows:

```
sudo cp -a ~/lab12-username/html/. /var/www/html/
```


### Supporting HTTPS

In order to support secure connections to your web server using HTTPS, you need to implement the following steps:

```
sudo apt install certbot -y
```

```
sudo apt install python3-certbot-nginx -y
```

```
sudo certbot --nginx -d <firstnamelastname>.sooners.us
```
where `<firstnamelastname>` is your first and last name with no spaces. Use the same name that you provided in the form in step 2.

Then, agree to certbot terms of service. Agree/disagree to sharing email with EFF. Finally, choose to redirect HTTP traffic to HTTPS (HTTP will still work when using the IP address).

**Note that the sub-domain will be set on Friday 04/28 (if you have submitted the form by the Thursday deadline). So, you will be able to complete setting up HTTPS only after that. When working on your code before that, you should still be able to access your website using the IP address and HTTP as you did in the previous lab.**

## 6-Submission 

For this lab, submit the link of your web page to canvas.
