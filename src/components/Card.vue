<template>
  <div class="card">
    <!-- {{ message }}
    <button @click="onClick">Change</button> -->
  </div>
</template>

<script>
export default {
  name: 'Card',
  data() {
    return {
      message: 'Try change me!'
    }
  },
  methods: {
    onClick() {
      this.message = 'Here you go'
    }
  }
}
</script>

<style>
.card {
  position: relative;
		top: 80%;
		left: 80%;
		display: inline-block;
		color: rgb(150, 12, 12);
		text-transform: uppercase;
		font-size: 20px;
		letter-spacing: 2px;
		padding: 10px 15px 10px 15px;
		border: 1px solid #FFF;
		transform: translate(-50%, -50%);

}
</style>