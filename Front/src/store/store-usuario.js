import jwt_decode from 'jwt-decode'


const state = {
  rol: jwt_decode(localStorage.getItem("token")).roles[0].authority
}

const mutations = {
    cambiarRol(state, payload) {
      state.rol = payload
    }
}

const actions = {
    actionscambiarRol({ commit } , rol) {
      commit('cambiarRol', rol)
    }
}

const getters = {
    
}

export default {
    state,
    mutations,
    actions,
    getters
}