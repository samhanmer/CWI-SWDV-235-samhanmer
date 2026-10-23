function validateForm() {
    const email = document.getElementById("email");
    const phone = document.getElementById("phoneNum");

    const emailRegex = /^[a-zA-Z0-9.-]+@[a-zA-Z-]+\.(com|edu|net|org|gov)$/; /* Validates email- checks for letters caps/lower, num 0-9 and possibly a . or -, then letters, then .com, ect. */
    const phoneRegex = /^\d{3}[-.\s]?\d{3}[-.\s]?\d{4}$/; /* Validates phone numbers. Checks for 3 digits, possibly a - . or a space or nothing, then three numbers, the same, then 4 digits. */

    if (!emailRegex.test(email.value)) {
        alert("Verify your email information is correct. (someone@email.com)"); 
        return false;
    }
    if (!phoneRegex.test(phone.value)) {
        alert("Verify your phone number is correct. (111-111-1111)"); 
        return false;
    }

    return true;
}