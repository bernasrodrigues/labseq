# Use the official Node.js image to build the Angular application
FROM node:18 AS build

# Set the working directory
WORKDIR /usr/src/app

# Install dependencies
COPY package*.json ./
RUN npm install
####
# Copy the source code
COPY . .

# Build the Angular application
RUN npm run build -- --configuration production

# Use a minimal Nginx image to serve the application
FROM nginx:alpine

# Copy the Angular build artifacts to the Nginx image
COPY --from=build /usr/src/app/dist/labseq-ui /usr/share/nginx/html

# Expose the port the app runs on
EXPOSE 80

# Run Nginx
CMD ["nginx", "-g", "daemon off;"]
