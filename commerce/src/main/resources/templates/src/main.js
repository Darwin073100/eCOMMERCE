
import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router'

//import {BootstrapVue, IconPlugin} from 'bootstrap-vue'
//Importacion de bootstrap al proyecto
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

createApp(App).use(router).mount('#app')
import 'bootstrap/dist/js/bootstrap'
