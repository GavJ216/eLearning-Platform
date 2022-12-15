<template>
  <div id="main">
    
      <h1>Home Wi-Fi security</h1>
      <p id="text">
If you are using a home Wi-Fi network to access the Internet, you should make sure it is secure; otherwise, your activity and information could be accessible to hackers and cybercriminals. 
Securing a wireless network can get technical, so beginners may prefer to get help from their Internet service providers (ISPs). When setting up your wireless security, consider the following tips.</p>

<ul>
  <li>Limit your signal strength so it cannot be detected beyond the boundaries of your home.</li>
  <li>Disable SSID broadcasting so your network is not visible to other wireless users within its signal range.</li>
  <li>Use a strong password. You should choose a password or passphrase that's easy for you to remember but difficult for others to guess.</li>
  <li>Enable MAC (Media Access Control) address filtering to prevent unauthorized wireless clients from breaking into your network.</li>
  <li>Make sure your network utilizes WPA (Wi-Fi Protected Access) or WPA2.</li>
  <li>If you use the older WEP (Wired Equivalent Privacy) instead of WPA, make sure to maximize the encryption.</li>
</ul> 

<h3>Public Wi-Fi safety tips</h3>
<p>Being able to access the Internet through Wi-Fi hotspots in coffee shops, hotels, airports, and other public spots can be quite convenient. However, these Wi-Fi hotspots are often not as secure as your home network.
   Review the following tips to learn how to stay safe when connecting to a public network.</p>

<ul>
  <li>Make sure you are on a legitimate network. Cybercriminals sometimes set up rogue networks with common names like Free Wi-Fi or Public Wi-Fi to get you to connect to illegitimate networks. Ask the hotspot owner for the name and login information for the hotspot you are visiting before you connect.</li>
  <li>Protect your computer by making sure your firewall is turned on and your antivirus software is up to date.</li>
  <li>Turn your Wi-Fi Connection to Network settings to a manual or non-automatic mode. This will prevent your computer from automatically picking up a signal and connecting to a network before you can determine whether it is legitimate.</li>
  <li>Go to your Network or Sharing settings and disable File and Printer Sharing to prevent others on the network from accessing your files. Depending on your operating system, there may be other sharing settings, like public folder sharing, that should also be turned off.</li>
  <li>Make sure you are aware of the people around you when using a hotspot. Keep an eye out for anyone who may be glancing over your shoulder and viewing your private information and activity. Never leave your laptop or mobile device unattended in a public space.</li>
  <li>Do not conduct financial transactions like banking or shopping with a credit card while using public hotspots.</li>
</ul> 

<div id="quiz-button-div">
<router-link :to="{ name: 'Quiz', params: {lessonId: 1}}" class="link">
  <button id='go-to-quiz'>Take Quiz</button>
</router-link>
</div>

  </div>
</template>

<script>
// import quizService from '../services/QuizService';

export default {
  
}
</script>

<style >
#main {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 50px;
    background-color: rgb(180, 219, 221);
    border-radius: 5px;
}

#before-quiz {
  margin-top: 30px;
  border: 1px solid black;
}

#quiz-button-div {
  margin: 15px;
}

#go-to-quiz {
    text-transform: uppercase;
    font-size: 15px;
    padding: 10px;
    border: none;
    margin: 10px;
    width: 10rem;
    height: 50px;
}

.photo {
    margin: 30px;
    width: 17rem;
    height: 17rem;
    /* border-radius: 50%; */
    
}

iframe {
    margin: 10px;
    border: gray solid 2px;
    border-radius: 2px;
}

.example {
    display: flex;
    flex-direction: column;
    font-size: 20px;
    align-items: center;
    background-color: white;
    max-width: 1000px;
    padding: 10px;
}

/* .example q {
  display: flex;
  justify-content: center;
  width: 200px;
}

.example p {
  display: flex;
  flex-wrap: wrap;
  align-content: flex-end;
  justify-content: center;
} */

</style>