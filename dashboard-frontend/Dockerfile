# Use a Node.js base image for building the Quasar app
FROM node:16 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the package files and install dependencies
COPY package*.json ./
RUN npm install

# Copy the rest of the app files
COPY . .

# Build the Quasar app
RUN npm run build

# Use an Nginx base image to serve the static files
FROM nginx:alpine

# Copy the built files to the Nginx directory
COPY --from=build /app/dist/spa /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]