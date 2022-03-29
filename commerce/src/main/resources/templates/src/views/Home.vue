<template>
    <div class="row">
        <span class="h2">Contenido Mas Popular</span>
        <div class="col">
            <px-card/>
        </div>
        <div class="col">
            <px-card/>
        </div>
        <div class="col">
            <px-card/>
        </div>
        <div class="col">
            <px-card/>
        </div>
    </div>
</template>
<script>
import PxCard from '@/components/user/PxCard.vue';

export default {
  components: { PxCard },
    name:'viewHome'
}
</script>