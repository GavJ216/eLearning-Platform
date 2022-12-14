<template>
<form>
    <p>Which of the following should you never use for a password?</p>
        <input type="radio" id="1" name='birth'>
        <label for='birthday'>Birthday</label>
        <input type="radio" id="2" name='name'>
        <label for='birthday'>Name</label>
        <input type="radio" id="3" name='gumba'>
        <label for='birthday'>Gumba</label>
        <input type="radio" id="4" name='choo'>
        <label for='4'>Choo Choo</label>

        <!-- <radio>Same password from another account</radio>
        <radio>The word “password”</radio>
        <radio>Your name</radio>
        <radio>All of the above</radio> -->
    
    <p>Why is it important to create different passwords for each of your online accounts?</p>
        <radio>It’s not that important</radio>
        <radio>With one password, hackers have access to multiple accounts</radio>
        <radio>Each site requires you to have a different password</radio>


    <p>What should a good password include?</p>
        <radio>More than 10 characters</radio>
        <radio>Contain uppercase and lowercase letters</radio>
        <radio>Numbers</radio>
        <radio>Symbols</radio>
        <radio>All of the above</radio>

    <p>Which of the following is the most secure password?</p>
        <radio>password</radio>
        <radio>123Abc</radio>
        <radio>chEwbAccAp!ZZa3!</radio>
        <radio>JohnSmith84!</radio>

    <p>What can you use to help keep track of all of your passwords?</p>
        <radio>Your brain</radio>
        <radio>Password Manager</radio>
        <radio>A friend</radio>
        <radio>Just have one password for everything</radio>

    <button type="submit">Submit</button>
    </form>
    </template>

<script>
export default {

}
</script>

<style>

</style>