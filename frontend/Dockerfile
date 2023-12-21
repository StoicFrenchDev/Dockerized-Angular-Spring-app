FROM node:18-alpine as build
WORKDIR /usr/src/app
ARG CONFIGURATION

COPY package*.json ./

RUN --mount=type=cache,target=/usr/src/app/.npm \
  npm set cache /usr/src/app/.npm && \
  npm install && \
  npm install -g @angular/cli

COPY . .

RUN npm run build --configuration=$CONFIGURATION

FROM build as dev
CMD ["ng", "serve", "--host", "0.0.0.0"]

FROM nginx:1.21-alpine as prod

# Use COPY --link to avoid breaking cache if we change the second stage base image
COPY --link nginx.conf /etc/nginx/conf.d/default.conf

COPY --link --from=build /usr/src/app/dist/angular-front /usr/share/nginx/html

EXPOSE 4200