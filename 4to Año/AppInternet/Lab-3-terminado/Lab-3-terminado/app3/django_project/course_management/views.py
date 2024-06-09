from django.shortcuts import render, redirect
from .models import Asignatura, Alumno
from django.http import JsonResponse

#las vistas son funciones que interactuan con la base de datos y los componentes html
def index(request):#carga todos los objetos de la clase asignatura en la tabla de pagina principal
    asignaturas = Asignatura.objects.all()
    alumnos = Alumno.objects.all()  # Recupera todos los alumnos
    return render(request, 'index.html', {'asignaturas': asignaturas, 'alumnos': alumnos})

def crear_asignatura(request):
    print("Entré a crear_asignatura")
    if request.method == 'POST':
        codigo = request.POST['codigo']#recuperamos codigo ingresado
        nombre = request.POST['nombre']#recuperamos nombre ingresado
        Asignatura.objects.create(codigo=codigo, nombre=nombre)#creamos un objeto de la clase asignatura
        return redirect('home')#volvemos a la pagina principal
    #return render(request, 'crear_asignatura.html')

from django.shortcuts import render, redirect, get_object_or_404
from django.http import HttpResponse
from .models import Alumno, Asignatura

def agregar_alumno(request):
    if request.method == 'POST':
        nombre = request.POST['nombre']
        apellido_paterno = request.POST['apellido_paterno']
        apellido_materno = request.POST['apellido_materno']
        fecha_nacimiento = request.POST['fecha_nacimiento']
        asignatura_nombre = request.POST['asignatura_tomada']

        # Buscar la asignatura por su nombre
        asignatura_existente = get_object_or_404(Asignatura, nombre=asignatura_nombre)

        # Crear un nuevo objeto Alumno y asociarlo a la asignatura encontrada
        if asignatura_existente:
            nuevo_alumno = Alumno.objects.create(
                nombre=nombre,
                apellido_paterno=apellido_paterno,
                apellido_materno=apellido_materno,
                fecha_nacimiento=fecha_nacimiento,
            )

            # Asociar el alumno a la asignatura encontrada
            nuevo_alumno.asignaturas_tomadas.add(asignatura_existente)

    # Redirigir a la página principal después de agregar al alumno
    return redirect('home')
       
def eliminar_alumno(request):
    if request.method == 'POST':
        # Obtener el ID del alumno desde los datos POST
        alumno_id = request.POST.get('alumno_a_eliminar', None)

        if alumno_id:
            # Obtener la instancia de Alumno basada en el ID
            alumno = get_object_or_404(Alumno, pk=alumno_id)

            # Eliminar al alumno
            alumno.delete()

    return redirect('home')

def eliminar_asignatura(request):   
    if request.method == 'POST':
        # Obtener el ID de la asignatura desde los datos POST
        asignatura_id = request.POST.get('asignatura_a_eliminar', None)

        if asignatura_id:
            # Obtener la instancia de Asignatura basada en el ID
            asignatura = get_object_or_404(Asignatura, pk=asignatura_id)

            # Recorrer todos los alumnos y eliminar la asignatura de sus listas
            alumnos = Alumno.objects.all()
            for alumno in alumnos:
                alumno.asignaturas_tomadas.remove(asignatura)

            # Eliminar la asignatura
            asignatura.delete()
    return redirect('home')
   

	