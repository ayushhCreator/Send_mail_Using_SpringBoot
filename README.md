# Spring Boot Email Service

## Overview
This project is a Spring Boot application that sends emails using Gmail's SMTP server. It demonstrates how to configure Spring Boot to send email notifications using Gmail, including setting up an **App Password** for secure authentication when **Two-Factor Authentication (2FA)** is enabled.

## Features
- Email sending functionality using Gmail SMTP.
- Configurable through Spring Boot properties.
- Secure authentication with Gmail using App Passwords.

## Requirements
- **Java 8 or higher**
- **Spring Boot 2.x**
- **Google Account with Two-Factor Authentication (2FA) enabled**
- **Maven** or **Gradle** for building the application.

## Steps to Get an App Password from Google

### 1. Enable Two-Factor Authentication (2FA)
To use Gmail's SMTP server securely, ensure that your Google Account has **2-Step Verification** enabled.
- Go to [Google Account Security](https://myaccount.google.com/security).
- Under **Signing in to Google**, enable **2-Step Verification**.
  
### 2. Generate an App Password
After enabling 2FA, you can generate an **App Password** for your Spring Boot application:
- Go to [Google Account App Passwords](https://myaccount.google.com/apppasswords).
- Select **Mail** as the app and choose **Other** as the device.
- Give the device a custom name like "Spring Boot App" and click **Generate**.
- Copy the 16-character **App Password** that is generated.

### 3. Configure Spring Boot Application
Now, configure your Spring Boot application to use the Gmail SMTP server with the generated App Password. 

#### **application.properties**
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
