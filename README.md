# SKYLINK Airline Management

Skylink Airline Management is a software solution that digitally handles issues such as purchasing flight tickets and hotel reservations.

![backend.png](..%2Fbackend.png)

## User Microservice (user-ms)

### Authentication, Authorization, and Registration Service

- **Endpoint:** `/user-ms/authentication`
    - **Method:** POST
    - **Access:** Permit all
    - **Description:** Allows users to log in.
    - **Request Body:**
      ```json
      { "username": "", "password": "" }
      ```
    - **Response Model:**
      ```json
      { "access-token": "", "refresh-token": "" }
      ```

- **Endpoint:** `/user-ms/renew-password/{username}`
    - **Method:** POST
    - **Access:** Permit all
    - **Description:** Initiates a password reset by sending a request to the user's email.
    - **Response Model:**
      ```json
      { "message": "" }
      ```
    - **Request Parameter:**
      ```
      token=
      ```

- **Endpoint:** `/user-ms/reset-password`
    - **Method:** POST
    - **Access:** Permit all
    - **Description:** Sets a new password.
    - **Request Body:**
      ```json
      { "newPassword": "", "repeatPassword": "" }
      ```
    - **Response Body:**
      ```json
      { "message": "" }
      ```

- **Endpoint:** `/user-ms/refresh-token`
    - **Method:** GET
    - **Access:** Authenticated
    - **Description:** Refreshes the user's token.
    - **Request Header:**
      ```
      Authentication: User-id:
      ```
    - **Response Body:**
      ```json
      { "access-token": "", "refresh-token": "" }
      ```

- **Endpoint:** `/user-ms/registration`
    - **Method:** POST
    - **Access:** Permit all
    - **Description:** Allows users to create an account, with authentication enabled only after email confirmation.
    - **Request Body:**
      ```json
      { "username": "", "password": "", "phoneNumber": "", "email": "", "birthdate": "", "paspFin": "", "paspSeria": "" }
      ```
    - **Response Body:**
      ```json
      { "message": "" }
      ```

- **Endpoint:** `/user-ms/confirmation`
    - **Method:** GET
    - **Access:** Permit all
    - **Description:** Endpoint for confirming the account after registering via email.
    - **Request Parameter:**
      ```
      token=
      ```
    - **Response Body:**
      ```json
      { "isConfirmed": "" }
      ```

- **Endpoint:** `/user-ms/admin/registration`
    - **Method:** POST
    - **Access:** Admin
    - **Description:** Allows adding a new admin, who must set a password by clicking on the link sent to their email.
    - **Request Body:**
      ```json
      { "username": "", "password": "", "phoneNumber": "", "email": "", "birthdate": "", "paspFin": "", "paspSeria": "" }
      ```
    - **Request Header:**
      ```
      Authentication: User-id:
      ```

## Booking Microservice (booking-ms)

### Service for Booking Tickets, Hotel Reservations, etc.

- **Endpoint:** `/booking-ms/booking/tickets`
    - **Method:** GET
    - **Access:** Authenticated
    - **Description:** Displays all tickets purchased by the user.
    - **Response Body:**
      ```json
      [{ "ticketId": "", "firstName": "", "lastName": "", "from": "", "to": "", "departureDateTime": "", "arrivalDateTime": "", "price": "", "flightId": "" }]
      ```

- **Endpoint:** `/booking-ms/booking/tickets/{ticketId}`
    - **Method:** GET
    - **Access:** Authenticated
    - **Description:** Allows the user to view details of a purchased ticket.
    - **Response Body:**
      ```json
      { "ticketId": "", "firstName": "", "lastName": "", "from": "", "to": "", "departureDateTime": "", "arrivalDateTime": "", "price": "", "flightId": "" }
      ```

- **Endpoint:** `/booking-ms/booking/tickets/{flightId}`
    - **Method:** POST
    - **Access:** Authenticated
    - **Description:** Allows the user to purchase a ticket for the selected flight. Produces information to Kafka with formatted ticketId. The Notification Microservice should consume this information and send the PDF as an email.
    - **Response Body:**
      ```json
      { "message": "" }
      ```

- **Endpoint:** `/booking-ms/booking/tickets/{ticketId}/pdf`
    - **Method:** GET
    - **Access:** Authenticated
    - **Description:** Allows the user to download the purchased ticket in PDF format.
    - **Response:** PDF file

## Flight Microservice (flight-ms)

### Service for Managing Flights

- **Endpoint:** `/flight-ms/flights`
    - **Method:** POST
    - **Access:** Admin
    - **Description:** Adds a new flight.
    - **Request Model:**
      ```json
      { "fromAirlineId": "", "toAirlineId": "", "departureDateTime": "", "arrivalDateTime": "", "initialPrice": "", "airplaneId": "" }
      ```
    - **Response Model:**
      ```json
      { "message": "" }
      ```

- **Endpoint:** `/flight-ms/flights`
    - **Method:** GET
    - **Access:** Permit all
    - **Description:** Displays all upcoming and available flights. Provides filtering options.
    - **Response Model:**
      ```json
      [{ "From": "", "To": "", "DepartureDateTime": "", "ArrivalDateTime": "", "price": "" }]
      ```

- **Endpoint:** `/flight-ms/flights/{id}`
    - **Method:** GET
    - **Access:** Permit all
    - **Description:** Displays details of the selected flight.
    - **Response Model:**
      ```json
      { "From": "", "To": "", "DepartureDateTime": "", "ArrivalDateTime": "", "price": "" }
      ```

- **Endpoint:** `/flight-ms/flights/{id}`
    - **Method:** DELETE
    - **Access:** Admin
    - **Description:** Deactivates the selected flight.
    - **Response Model:**
      ```json
      { "message": "" }
      ```

- **Endpoint:** `/flight-ms/flights/{id}`
    - **Method:** PUT
    - **Access:** Admin
    - **Description:** Allows the admin to modify details of the selected flight.
    - **Request Model:**
      ```json
      { "fromAirlineId": "", "toAirlineId": "", "departureDateTime": "", "arrivalDateTime": "", "initialPrice": "", "airplaneId": "" }
      ```
    - **Response Model:**
      ```json
      { "message": "" }
      ```

- **

Endpoint:** `/flight-ms/flights/{id}`
- **Method:** PATCH
- **Access:** Admin
- **Description:** Allows the admin to change the `available`, `isFly`, and other fields of the selected flight.
- **Request Model:**
  ```json
  { "isFly": "" }
  ```
- **Response Model:**
  ```json
  { "message": "" }
  ```

## Airplane Microservice (airplane-ms)

### Service for Managing Airplanes

- **Endpoint:** `/airplane-ms/airplanes`
    - **Method:** GET
    - **Access:** Admin
    - **Description:** Displays all airplanes. Can filter to show only available or all airplanes.
    - **Request Parameter:**
      ```
      busy=
      ```
    - **Response Body:**
      ```json
      [{ "Id": "", "Name": "", "Max seats": "", "Max speed": "" }]
      ```

- **Endpoint:** `/airplane-ms/airplanes/{id}`
    - **Method:** GET
    - **Access:** Admin
    - **Description:** Displays details of the selected airplane.
    - **Response Body:**
      ```json
      { "Name": "", "Max seats": "", "Max speed": "" }
      ```

- **Endpoint:** `/airplane-ms/airplanes`
    - **Method:** POST
    - **Access:** Admin
    - **Description:** Adds a new airplane.
    - **Request Body:**
      ```json
      { "Name": "", "Max seats": "", "Max speed": "" }
      ```
    - **Response Body:**
      ```json
      { "message": "" }
      ```

- **Endpoint:** `/airplane-ms/airplanes`
    - **Method:** PUT
    - **Access:** Admin
    - **Description:** Allows the admin to update details of the selected airplane.
    - **Request Model:**
      ```json
      { "Id": "", "Name": "", "Max seats": "", "Max speed": "" }
      ```
    - **Response Model:**
      ```json
      { "message": "" }
      ```

- **Endpoint:** `/airplane-ms/airplanes/{id}`
    - **Method:** DELETE
    - **Access:** Admin
    - **Description:** Deletes the selected airplane from the database.
    - **Response Model:**
      ```json
      { "message": "" }
      ```

- **Endpoint:** `/airplane-ms/airplanes/{id}`
    - **Method:** PATCH
    - **Access:** Admin
    - **Description:** Changes the `isBusy` field of the selected airplane.
    - **Request Parameter:**
      ```
      IsBusy=
      ```
    - **Response Body:**
      ```json
      { "message": "" }
      ```

## Notification Microservice (notification-ms)

Notification microservice consumes information produced by other services (e.g., booking-ms) from Kafka and sends emails.

## Common Microservice (common-ms)

### Common Endpoints and Utilities

- **Endpoint:** `/common-ms/airlines`
    - **Method:** GET
    - **Access:** Admin
    - **Description:** Retrieves a list of airlines for use in dropdowns, filtering available based on optional parameters.
    - **Request Parameter:**
      ```
      country: airline:
      ```
    - **Response Body:**
      ```json
      [ { "id": "", "country": "", "name": "", "airline": "" }, { "id": "", "country": "", "name": "", "airline": "" } ]
      ```

- **Endpoint:** `/common-ms/airlines/{id}`
    - **Method:** GET
    - **Access:** Admin
    - **Description:** Retrieves details of the selected airline.
    - **Response Body:**
      ```json
      { "id": "", "country": "", "name": "", "airline": "" }
      ```

## Libraries (Libs)

### Libraries and Utilities

- `common-exception`: Handles common exceptions for all services.
- `common-email`: Provides services and objects for sending emails.
- `common-notification`: Handles the production and consumption of notification information.
- `common-security`: Implements general security logic, requiring Authentication header and User-id for authenticated endpoints.
- `common-file-generator`: Provides PDF generation utilities for creating and sending tickets in PDF format.

## Common Information

- Implement validation on request models.
- Include the `Authentication` header and `User-id` in authenticated endpoint headers.
- Customize response codes and error messages for a better user experience.
- Address potential race conditions when multiple users access the same resources concurrently.
- Any additional common functionalities can be added to the `common-ms` service.
