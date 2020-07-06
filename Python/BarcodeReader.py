from PIL import Image
import pyzbar.pyzbar as pyzbar

# Import barcode
barcode = Image.open("Images/toDecode.png")

# Decode barcode
decodedObject = pyzbar.decode(barcode)

# Print barcode information
for obj in decodedObject:
    print(obj.data)
