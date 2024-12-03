# Stage 1: Build the Quasar app
FROM node:18 as build-stage

# Set working directory
WORKDIR /app

# Copy package.json and package-lock.json to install dependencies
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the Quasar app
RUN npm run build

# Stage 2: Serve the app with Nginx
FROM nginx:stable-alpine as production-stage

# Copy the built files from the first stage to Nginx's web directory
COPY --from=build-stage /app/dist/spa /usr/share/nginx/html

# Copy a custom Nginx configuration file if needed (optional)
# Uncomment if you want a custom Nginx configuration
# COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
