from django.urls import path

from . import views

#esto define todas las rutas que maneja la pagina
#en este caso la pagina principal se define siempre como '' y llama al metodo index del archivo view

urlpatterns = [
    path('', views.index, name="home"),#la pagina principal llama al metodo index que carga los datos en la tabla
    path('crear_asignatura/', views.crear_asignatura, name='crear_asignatura'),
    # En urls.py
    path('agregar_alumno/', views.agregar_alumno, name='agregar_alumno'),
    path('eliminar_alumno/', views.eliminar_alumno, name='eliminar_alumno'),
    path('eliminar_asignatura/', views.eliminar_asignatura, name='eliminar_asignatura'),
]