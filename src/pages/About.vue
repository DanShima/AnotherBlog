<template>
  <Layout>
    <div class="penguin">
  <div class="penguin-bottom">
    <div class="right-hand"></div>
    <div class="left-hand"></div>
    <div class="right-feet"></div>
    <div class="left-feet"></div>
  </div>
  <div class="penguin-top">
    <div class="right-cheek"></div>
    <div class="left-cheek"></div>
    <div class="belly"></div>
    <div class="right-eye">
      <div class="sparkle"></div>
    </div>
    <div class="left-eye">
      <div class="sparkle"></div>
    </div>
    <div class="blush-right"></div>
    <div class="blush-left"></div>
    <div class="beak-top"></div>
    <div class="beak-bottom"></div>
  </div>
</div>
    <p>A self-taught programmer with a background in education and literature.
      Born in China, grew to full-size in the Netherlands, and now based in Stockholm, Sweden.
      When I'm not juggling a million interests ranging from food, art, programming, nerd culture, synth/darkwave music, longboarding to games,
      I focus on improving my specialization in Android development, while shaking my restless leg.
    </p>
    <h2>Tech skills and languages</h2>
      <ul>
        <li>Build android applications with Java and Kotlin</li>
        <li>Build frontend web applications with Angular.js and Vue.js</li>
        <li>Build games with Unity, Blender and LibGDX</li>
        <li>Experience with: Java, Kotlin, C#, C++, Python, JS/HTML/CSS</li>
        <li>CI/CD, infrastructure and operations, build and release management,
          basic understanding of networking and security</li>
      </ul>
    <h2>Games</h2>
    <ul>
      <li><a href="https://hookagnome.web.app/" target="_blank" rel="noopener">HookaGnome</a></li>
      <li><a href="https://github.com/DanShima/GameProject" target="_blank" rel="noopener">Gear Up</a></li>
    </ul>
    <h2>Hackathons/Gamejams</h2>
    <p>2019</p>
    <ul>
      <li>LiveHacks #6- winning team</li>
    </ul>
    <p>2018</p>
    <ul>
      <li>LiveHacks- individual winner</li>
      <li>Hack4Sweden</li>
      <li>Siemens hackathon - second runner-up</li>
      <li>Truecaller women-only android hackathon - winning team</li>
      <li>King Game Jam - winning team in UX design, creativity and fun awards</li>
      <li>Junction</li>
    </ul>
    <Card/>
  </Layout>
</template>

<style>
  h1, h2 {
    font-family: "Stylish";
  }

  a {
    text-decoration: none;
  }
  .penguin {

    /* use css variables to change many style properties at once */
    --penguin-skin: rgb(155, 151, 151);
    --penguin-belly: white;
    --penguin-beak: rgb(247, 172, 35);

    position: relative;
    margin: auto;
    display: block;
    margin-top: 5%;
    width: 300px;
    height: 300px;
  }

  .penguin-top {
    top: 10%;
    left: 25%;
    background: var(--penguin-skin, gray);
    width: 50%;
    height: 45%;
    border-radius: 70% 70% 60% 60%;
  }

  .penguin-bottom {
    top: 40%;
    left: 23.5%;
    background: var(--penguin-skin, gray);
    width: 53%;
    height: 45%;
    border-radius: 70% 70% 100% 100%;
  }

  .right-hand {
    top: 0%;
    left: -5%;
    background: var(--penguin-skin, gray);
    width: 30%;
    height: 60%;
    border-radius: 30% 30% 120% 30%;
    transform: rotate(45deg);
    z-index: -1;
  }

  .penguin:hover .right-hand{
    top: 5%;
    left: 25%;
    background: var(--penguin-skin, black);
    width: 30%;
    height: 50%;
    border-radius: 30% 30% 120% 30%;
    transform: rotate(130deg);
    z-index: -1;
    animation-duration: 3s;
    animation-name: wave;
    animation-iteration-count: infinite;
    transform-origin:0% 0%;
    animation-timing-function: linear;
  }

  @keyframes wave {
      10% {
        transform: rotate(110deg);
      }
      20% {
        transform: rotate(130deg);
      }
      30% {
        transform: rotate(110deg);
      }
      40% {
        transform: rotate(130deg);
      }
    }

  .left-hand {
    top: 0%;
    left: 75%;
    background: var(--penguin-skin, gray);
    width: 30%;
    height: 60%;
    border-radius: 30% 30% 30% 120%;
    transform: rotate(-45deg);
    z-index: -1;
  }

  .right-cheek {
    top: 15%;
    left: 35%;
    background: var(--penguin-belly, white);
    width: 60%;
    height: 70%;
    border-radius: 70% 70% 60% 60%;
  }

  .left-cheek {
    top: 15%;
    left: 5%;
    background: var(--penguin-belly, white);
    width: 60%;
    height: 70%;
    border-radius: 70% 70% 60% 60%;
  }

  .belly {
    top: 60%;
    left: 2.5%;
    background: var(--penguin-belly, white);
    width: 95%;
    height: 100%;
    border-radius: 120% 120% 100% 100%;
  }

  .right-feet {
    top: 85%;
    left: 60%;
    background: var(--penguin-beak, orange);
    width: 15%;
    height: 30%;
    border-radius: 50% 50% 50% 50%;
    transform: rotate(-80deg);
    z-index: -2222;
  }

  .left-feet {
    top: 85%;
    left: 25%;
    background: var(--penguin-beak, orange);
    width: 15%;
    height: 30%;
    border-radius: 50% 50% 50% 50%;
    transform: rotate(80deg);
    z-index: -2222;
  }

  .right-eye {
    top: 45%;
    left: 60%;
    background: black;
    width: 15%;
    height: 17%;
    border-radius: 50%;
  }

  .left-eye {
    top: 45%;
    left: 25%;
    background: black;
    width: 15%;
    height: 17%;
    border-radius: 50%;
  }

  .sparkle {
    top: 25%;
    left: 15%;
    background: white;
    width: 35%;
    height: 35%;
    border-radius: 50%;
  }

  .blush-right {
    top: 65%;
    left: 15%;
    background: pink;
    width: 15%;
    height: 10%;
    border-radius: 50%;
  }

  .blush-left {
    top: 65%;
    left: 70%;
    background: pink;
    width: 15%;
    height: 10%;
    border-radius: 50%;
  }

  .beak-top {
    top: 60%;
    left: 40%;
    background: var(--penguin-beak, orange);
    width: 20%;
    height: 10%;
    border-radius: 50%;
  }

  .beak-bottom {
    top: 65%;
    left: 42%;
    background: var(--penguin-beak, orange);
    width: 16%;
    height: 10%;
    border-radius: 50%;
  }

  .penguin * {
    position: absolute;
  }
</style>

<script>
import Card from '~/components/Card.vue'
export default {
  components: {
    Card
  },
  metaInfo: {
    title: 'About me'
  }
}
</script>
