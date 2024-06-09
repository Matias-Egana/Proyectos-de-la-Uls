import cv2
import pytesseract
import re

# Configuración de Tesseract
pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract'
ruta_imagen = 'imagen/dbty13-front.jpeg'
# Lectura de la imagen
image = cv2.imread(ruta_imagen)

# Convertir a escala de grises
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Aplicar umbralización
_, thresh = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

# Realizar operaciones morfológicas para eliminar el ruido
kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (3, 3))
opening = cv2.morphologyEx(thresh, cv2.MORPH_OPEN, kernel, iterations=1)

# Encontrar contornos
cnts, _ = cv2.findContours(opening, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

# Iterar sobre los contornos
for c in cnts:
    x, y, w, h = cv2.boundingRect(c)
    
    # Filtrar contornos basados en el área y la relación de aspecto
    if cv2.contourArea(c) > 5000 and 1 < w / h < 5:
        # Recortar región de interés
        roi = gray[y:y+h, x:x+w]
        
        # Aplicar OCR a la región de interés
        text = pytesseract.image_to_string(roi, config='--psm 6')
        
        # Limpiar y mostrar el texto
        cleaned_text = ''.join(filter(str.isalnum, text))
        
        # Filtrar por longitud del texto y caracteres válidos
        if len(cleaned_text) == 6 and re.match(r'^[A-Z0-9]+$', cleaned_text):
            print('PATENTE ENCONTRADA:', cleaned_text)

            # Dibujar rectángulo alrededor de la placa
            cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)
            cv2.putText(image, cleaned_text, (x, y - 10), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)

# Mostrar imagen
cv2.imshow('Resultados', image)
cv2.waitKey(0)
