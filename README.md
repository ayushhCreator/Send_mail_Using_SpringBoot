To send emails from a Spring Boot application using Gmail, you'll need to use an App Password if you have enabled Two-Factor Authentication (2FA) for your Google account. Here's how you can generate an App Password to use in your Spring Boot application:

Steps to Get an App Password from Google:
Ensure Two-Factor Authentication (2FA) is Enabled:

Go to your Google Account.
Under Security, ensure that 2-Step Verification is enabled.
If it's not enabled, follow the prompts to enable 2-Step Verification.
Generate an App Password:

Once 2FA is enabled, go to the Security section of your Google Account.
Under Signing in to Google, find App passwords and click on it.
You may be prompted to re-enter your password.
In the App passwords section, select the following:
Select App: Choose Mail (or any other option related to your Spring Boot app, like "Other (Custom name)").
Select Device: Choose Other and type a custom name (e.g., "Spring Boot App").
Click on Generate.
A 16-character App Password will be displayed. This is the password you'll use for sending emails from your Spring Boot application.
Configure Spring Boot to Use the App Password:

In your application.properties or application.yml file, configure your Gmail SMTP settings with the generated App Password.
For application.properties:

properties
Copy code
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
For application.yml:


Send an Email Using Spring Boot: Once the App Password is configured in your application.properties or application.yml file, you can use the JavaMailSender in your Spring Boot service to send emails as usual.
