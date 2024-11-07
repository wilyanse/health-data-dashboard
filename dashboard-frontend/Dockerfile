# Use an official Node.js runtime as a parent image
FROM node:16-slim

# Set the working directory
WORKDIR /app

# Install dependencies
COPY package.json package-lock.json ./
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the Quasar app (optional, if you're using Quasar's production build)
RUN npm run build

# Expose port 9000 to make Quasar available externally
EXPOSE 9000

# Start the app
CMD ["npm", "run", "dev"]