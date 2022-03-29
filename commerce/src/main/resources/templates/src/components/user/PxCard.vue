<template>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <span class="h3">Sistemas disponibles</span>
            </div>
            <div class="card-body center">
                <img src="./logo.png" :alt="imgName">
            </div>
            <div class="card-footer">
                <input type="submit" value="Más Información" class="btn btn-primary">
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name:'PxCard',
    data(){
        return{
            imgName: 'Sistema 1',
            img:"./logo.png"
        }
    }
}
</script>