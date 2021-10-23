FROM ubuntu
ENV TZ=Europe/Minsk
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN apt-get update -y && apt-get install -y apache2 apache2-utils
COPY hola.html /var/www/html/hola.html
CMD /usr/sbin/apache2ctl -D FOREGROUND