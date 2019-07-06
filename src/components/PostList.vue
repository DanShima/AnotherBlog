<template>
  <div class="post-list">
    <hr class="line" />
    <p class="date" v-html="post.date" />
    <h1 class="title" v-html="post.title" />
    <p class="description" v-html="post.description" />
    <b class="timeToRead"> {{post.timeToRead}} min read </b>  &nbsp;
    <g-link :to="post.path" class="read">Read more
      <i class="arrow">
      <font-awesome :icon="['fa', 'chevron-right']" size="xs"/>
      <font-awesome :icon="['fa', 'chevron-right']" size="xs"/>
      <font-awesome :icon="['fa', 'chevron-right']" size="xs"/>
      </i>
    </g-link>
  </div>
</template>

<style>
.line {
  border: 0.5px solid #cdc8c5;
  margin: 30px 0;
}
.date {
  font-weight: 300;
}

.timeToRead {
  color: #86A3C5;
}
.read {
  --text-color: #86A3C3;
  color: var(--text-color);
  text-decoration: none;
  border-radius: 2%;
  box-shadow: 0 1px 1px var(--text-color), 0 1px 1px var(--text-color);
  text-transform: uppercase;
  letter-spacing: 2px;
  padding: 8px 10px 8px 10px;
  border: 1px solid var(--text-color);
	transform: translate(-50%, -50%);
}

i {
		animation: arrow-animation 2s;
		animation-iteration-count: infinite;
	}
i:first-child{
		animation-delay: 0.2s;
		margin-left: 5px;
		opacity: 0.15;
	}
i + i {
		animation-delay: 0.4s;
		opacity: 0.5;
	}
i + i + i {
		animation-delay: 0.6s;
		opacity: 1;
	}

.read:hover {
    cursor: pointer;
    color: white;
    background-color: var(--text-color);
  }

i:hover {
    color: white;
}

@keyframes arrow-animation {
  0%   { opacity: 0.1; }
  50%  { opacity: 0.5; }
  100% { opacity: 1; }
}


</style>

<script>
export default {
  props: ["post"],
};
</script>