# ─────────────────────────────────────────────────
# Stage 1 – Build: Copy static website assets
# ─────────────────────────────────────────────────
FROM nginx:alpine
# Maintainer label
LABEL maintainer="pranavkrishna" \
project="mavenopness" \
description="static website served via Nginx"
# Remove default Nginx welcome page
RUN rm -rf /usr/share/nginx/html/*
# Copy static website files into Nginx's serving directory
COPY src/main/resources/index.html /usr/share/nginx/html/index.html
COPY src/main/resources/style.css /usr/share/nginx/html/style.css
COPY src/main/resources/logo.svg /usr/share/nginx/html/logo.svg
# Expose port 80 (Nginx default)
EXPOSE 80
# Start Nginx in the foreground (required for Docker)
CMD ["nginx", "-g", "daemon off;"]