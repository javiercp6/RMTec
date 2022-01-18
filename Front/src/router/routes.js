
const routes = [
  {
    path: '/',
    component: () => import('src/layouts/LayoutSolicitante.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
      { path: 'Solicitud', component: () => import('pages/SolicitudPage.vue') },
      { path: 'ayuda', component: () => import('pages/Ayuda.vue') },
      { path: 'acerca_de', component: () => import('pages/AcercaDe.vue') },
      { path: 'adminsolicitud', component: () => import('pages/AdministrarSolicitudPage.vue') },
      { path: 'custodiosolicitud', component: () => import('pages/CustodioSolicitudPage.vue') },
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes