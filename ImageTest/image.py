import qrcode
from PIL import Image, ImageDraw

base = 128


def get(integer):
    return int(base * (integer / 128))


image = Image.new("RGB", (128, 128), (255, 255, 255))

qrc = qrcode.QRCode(
    error_correction=qrcode.constants.ERROR_CORRECT_L,
    box_size=get(4.5)
)
qrc.add_data("https://peya.tokyo/")
qrc.make()
image.paste(qrc.make_image(), (get(1), get(1)))

image.save("a.png")
image.show()
